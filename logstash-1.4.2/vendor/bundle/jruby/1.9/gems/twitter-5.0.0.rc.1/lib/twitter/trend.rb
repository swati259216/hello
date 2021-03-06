require 'twitter/base'

module Twitter
  class Trend < Twitter::Base
    attr_reader :events, :name, :promoted_content, :query
    uri_attr_reader :uri

    # @param other [Twitter::Trend]
    # @return [Boolean]
    def ==(other)
      super || attr_equal(:name, other) || attrs_equal(other)
    end

  end
end
